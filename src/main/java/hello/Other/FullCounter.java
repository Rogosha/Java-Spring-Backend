package hello.Other;

public class FullCounter {
    private Counter outstanding;
    private Counter veryGood;
    private Counter good;
    private Counter adequate;
    private Counter needsImprovements;
    private Counter poor;
    private Counter dontNot;

    public FullCounter(Counter outstanding, Counter veryGood, Counter good, Counter adequate, Counter needsImprovements, Counter poor, Counter dontNot) {
        this.outstanding = outstanding;
        this.veryGood = veryGood;
        this.good = good;
        this.adequate = adequate;
        this.needsImprovements = needsImprovements;
        this.poor = poor;
        this.dontNot = dontNot;
    }

    public FullCounter() {
    }

    public Counter getOutstanding() {
        return outstanding;
    }

    public void setOutstanding(Counter outstanding) {
        this.outstanding = outstanding;
    }

    public Counter getVeryGood() {
        return veryGood;
    }

    public void setVeryGood(Counter veryGood) {
        this.veryGood = veryGood;
    }

    public Counter getGood() {
        return good;
    }

    public void setGood(Counter good) {
        this.good = good;
    }

    public Counter getAdequate() {
        return adequate;
    }

    public void setAdequate(Counter adequate) {
        this.adequate = adequate;
    }

    public Counter getNeedsImprovements() {
        return needsImprovements;
    }

    public void setNeedsImprovements(Counter needsImprovements) {
        this.needsImprovements = needsImprovements;
    }

    public Counter getPoor() {
        return poor;
    }

    public void setPoor(Counter poor) {
        this.poor = poor;
    }

    public Counter getDontNot() {
        return dontNot;
    }

    public void setDontNot(Counter dontNot) {
        this.dontNot = dontNot;
    }
}
