import io.activej.http.AsyncServlet;
import io.activej.http.HttpResponse;
import io.activej.inject.annotation.Provides;
import io.activej.launchers.http.HttpServerLauncher;
import java.time.LocalDateTime;

public class AdSelectionSyncApplication extends HttpServerLauncher {

    @Provides
    AsyncServlet selectAds() {
        return request -> {
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime fiveSeconds = now.plusSeconds(5);

            //FIXME this will cause main loop to stuck on first request, pass to second request only it finishes
            while (LocalDateTime.now().isBefore(fiveSeconds)) {

            }
            return HttpResponse.ok200()
                .withPlainText("Ad selection service");
        };

    }

}
