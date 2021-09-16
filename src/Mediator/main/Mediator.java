package Mediator.main;

import Mediator.component.Component;
import Mediator.model.Note;

import javax.swing.*;

public interface Mediator {

    void registerComponent(Component component);

    void addNewNote(Note note);

    void deleteNote();

    void getInfoFromList(Note note);

    void saveChanges();

    void markNote();

    void clear();

    void sendToFilter(ListModel listModel);

    void setElementsList(ListModel list);


    void hideElements(boolean flag);

    void createGUI();
}
