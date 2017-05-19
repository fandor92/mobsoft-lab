package mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto;

import javax.inject.Singleton;

import dagger.Component;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.Interactor.InteractorModule;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.mock.MockNetworkModule;
import mobsoft.win.the.afor.bullshit.aut.bme.autonyilvantarto.repository.TestRepositoryModule;

@Singleton
@Component(modules = {MockNetworkModule.class, TestModule.class, InteractorModule.class, TestRepositoryModule.class})
public interface TestComponent extends AutonyilvantartoApplicationComponent {

}