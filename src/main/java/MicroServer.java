import io.activej.http.AsyncServlet;
import io.activej.http.HttpResponse;
import io.activej.inject.annotation.Provides;
import io.activej.launcher.Launcher;
import io.activej.launchers.http.HttpServerLauncher;

public class MicroServer extends HttpServerLauncher {

    @Provides
    AsyncServlet servlet() {
        return request -> HttpResponse.ok200()
                .withPlainText("Hello World");
    }

    public static void main(String[] args) throws Exception {
        Launcher launcher = new MicroServer();
        launcher.launch(args);
    }

}
