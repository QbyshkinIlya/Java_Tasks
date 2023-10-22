package Builders;

public class BMI {
    private float height;
    private float ves;

    public void setHeight(float height) {
        this.height = height;
    }

    public void setVes(float ves) {
        this.ves = ves;
    }

    public float getHeight() {
        return height;
    }

    public float getVes() {
        return ves;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BMI bmi = (BMI) o;

        if (Float.compare(bmi.height, height) != 0) return false;
        return Float.compare(bmi.ves, ves) == 0;
    }

    @Override
    public int hashCode() {
        int result = (height != +0.0f ? Float.floatToIntBits(height) : 0);
        result = 31 * result + (ves != +0.0f ? Float.floatToIntBits(ves) : 0);
        return result;
    }
}
