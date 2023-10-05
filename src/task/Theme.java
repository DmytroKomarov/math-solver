package task;
public class Theme {
    private String themeCode;
    private String themeDescription;

    public Theme(String themeCode, String themeDescription) {
        this.themeCode = themeCode;
        this.themeDescription = themeDescription;
    }

    public String getThemeCode() {
        return themeCode;
    }

    public void setThemeCode(String themeCode) {
        this.themeCode = themeCode;
    }

    public String getThemeDescription() {
        return themeDescription;
    }

    public void setThemeDescription(String themeDescription) {
        this.themeDescription = themeDescription;
    }

    @Override
    public String toString() {
        return this.themeDescription;
    }
}
