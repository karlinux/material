package mx.com.aulaxalapa.material.utils;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Objects;

public class Component {

    private String name;
    private int phtpRes;
    private int type;

    public Component() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhtpRes() {
        return phtpRes;
    }

    public void setPhtpRes(int phtpRes) {
        this.phtpRes = phtpRes;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Component component = (Component) o;
        return phtpRes == component.phtpRes &&
                type == component.type &&
                Objects.equals(name, component.name);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(name, phtpRes, type);
    }
}
