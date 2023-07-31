import io.activej.common.exception.UncheckedException;
import io.activej.eventloop.Eventloop;
import io.activej.http.AsyncHttpServer;
import io.activej.http.AsyncServlet;
import io.activej.http.HttpRequest;
import io.activej.http.HttpResponse;
import io.activej.inject.annotation.Eager;
import io.activej.inject.annotation.Provides;
import io.activej.inject.module.Module;
import io.activej.launcher.Launcher;
import io.activej.promise.Promisable;
import io.activej.service.ServiceGraphModule;
import org.jetbrains.annotations.NotNull;
public class Application extends Launcher  {

    private static final int PORT = 8080;

    @Provides
    Eventloop eventloop() {
        return Eventloop.create();
    }

    AsyncServlet heartbeat() {
        return new AsyncServlet() {
            @Override
            public @NotNull Promisable<HttpResponse> serve(@NotNull HttpRequest request) throws UncheckedException {
                try {
                    Thread.sleep(10 * 1000);
                    return HttpResponse.ok200()
                        .withPlainText("Ad selection service");
                } catch (InterruptedException e) {
                    return HttpResponse.ok200()
                        .withPlainText("Ad selection service failed");
                }
            }
        };
    }

    @Provides
    AsyncServlet selectAds() {
        return request -> {
            try {
                Thread.sleep(10 * 1000);
                return HttpResponse.ok200()
                    .withPlainText("Ad selection service");
            } catch (InterruptedException e) {
                return HttpResponse.ok200()
                    .withPlainText("Ad selection service failed");
            }
        };

    }

    @Provides
    @Eager
    AsyncHttpServer server(Eventloop eventloop, AsyncServlet servlet) {
        return AsyncHttpServer.create(eventloop, servlet).withListenPort(PORT);
    }

    @Override
    protected Module getModule() {
        return ServiceGraphModule.create();
    }

    @Override
    protected void run() throws Exception {
        logger.info("HTTP Server is now available at http://localhost:" + PORT);
        awaitShutdown();
    }
}
