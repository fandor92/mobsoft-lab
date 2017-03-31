package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto;

import javax.inject.Singleton;

import dagger.Component;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.UIModule;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.ui.main.MainActivity;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

@Singleton
@Component(modules = {UIModule.class})
public interface AutonyilvantartoApplicationComponent {
    void inject(MainActivity mainActivity);

}
