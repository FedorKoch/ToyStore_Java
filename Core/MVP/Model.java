package Core.MVP;

import Core.Infrastructure.Box;
import Core.Infrastructure.Prize;

public class Model {
    private Box currentToyBox;
    private Prize prizeBoxQueue;

    public Model() {
        currentToyBox = new Box();
        prizeBoxQueue = new Prize();
    }

    public Box getCurrentToyBox() {
        return this.currentToyBox;
    }

    public Prize getPrizeBoxQueue() {
        return this.prizeBoxQueue;
    }
}