package component;

import main.Mediator;

public interface Component {
    void setMediator(Mediator mediator);

    String getName();
}
