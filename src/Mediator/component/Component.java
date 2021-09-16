package Mediator.component;

import Mediator.main.Mediator;

public interface Component {
    void setMediator(Mediator mediator);

    String getName();
}
