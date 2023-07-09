package Core.MVP;

import Core.Models.Toy;

public class Presenter {

    private Model model;
    private ConsoleView view;

    public Presenter(ConsoleView view, Model model) {
        this.view = view;
        this.model = model;

    }

    public void addToy() {
        view.consoleClear();
        model.getCurrentToyBox()
                .putToy(new Toy(view.getToyName(),
                        view.getToyProbability()));
        view.showSuccessAddinMess();
        view.userWaiting();
    }

    public void getPrizeToy() {
        view.consoleClear();
        Toy prizeToy = model.getCurrentToyBox().getPrizeToy();
        if (prizeToy == null) {
            view.showEmptyBoxMess();
            view.userWaiting();
        } else {
            view.showSuccessDrawingMess();
            view.display(prizeToy.toString());
            model.getPrizeBoxQueue().addToQueue(prizeToy);
            view.showAddinToPrizeBoxMess();
            view.userWaiting();
        }
    }

    public void getPrizeToyFromQueue() {
        view.consoleClear();
        Toy prizeToy = model.getPrizeBoxQueue().getToyFromQueue();
        if (prizeToy == null) {
            view.showEmptyQueueMess();
            view.userWaiting();
        } else {
            view.showPrizeToyMess();
            view.display(prizeToy.toString());
            view.display(prizeToy.exportToFile());
            view.userWaiting();
        }
    }


    public void exitApp() {
        view.consoleClear();
        view.showGoobyeMess();
    }

    public void unknownCommand() {
        view.consoleClear();
        view.showUnknownCommMess();
        view.userWaiting();
    }

    public String showMenu() {
        view.consoleClear();
        return view.showMenu();
    }

    public void consoleClear() {
        view.consoleClear();
    }

    public void printToysFromBox() {
        view.consoleClear();
        view.display(model.getCurrentToyBox().toString());
        view.userWaiting();
    }

    public void printPrizeToys() {
        view.consoleClear();
        view.display(model.getPrizeBoxQueue().toString());
        view.userWaiting();
    }

    public void setToyProbability(){
        view.consoleClear();
        int idToChange = -1;
        while (idToChange < 0) {
            idToChange = view.getId();
            view.userWaiting();
        }
        if (model.getCurrentToyBox().getToyById(idToChange) == null) {
            view.showWrongIdMess();
            view.userWaiting();
        } else {
            int newProbability = view.getToyProbability();
            model.getCurrentToyBox().getToyById(idToChange).setProbability(newProbability);
            view.showSuccessChangeIdMess();
            view.userWaiting();
        }

    }
}