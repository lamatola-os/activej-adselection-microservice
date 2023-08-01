import io.activej.eventloop.Eventloop;
import io.activej.http.AsyncHttpServer;
import io.activej.http.AsyncServlet;
import io.activej.http.HttpResponse;
import io.activej.inject.annotation.Eager;
import io.activej.inject.annotation.Provides;
import io.activej.inject.module.Module;
import io.activej.launcher.Launcher;
import io.activej.service.ServiceGraphModule;
public class AdSelectionApplication extends Launcher  {

    private static final int PORT = 8081;

    @Provides
    Eventloop eventloop() {
        return Eventloop.create();
    }

    AsyncServlet heartbeat() {
        return request -> HttpResponse.ok200()
            .withPlainText("Ad selection service");
    }

    @Provides
    AsyncServlet selectAds() {
        return request -> {
            try {
                Thread.sleep(5 * 1000);
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
