package com.domain;

import java.io.Serializable;
import java.util.List;

public class Menu implements Serializable {
    private Integer mno;
    private String mname;
    private String mhref;
    private String mtarget;
    private Integer pno;//所属父级菜单编号

    private Menu parent;
    private List<Menu> children;
    private String yl1;
    private String yl2;

    public Menu() {}

    public Menu(Integer mno, String mname, String mhref, String mtarget, Integer pno, Menu parent, List<Menu> children, String yl1, String yl2) {
        this.mno = mno;
        this.mname = mname;
        this.mhref = mhref;
        this.mtarget = mtarget;
        this.pno = pno;
        this.parent = parent;
        this.children = children;
        this.yl1 = yl1;
        this.yl2 = yl2;
    }

    public Integer getMno() {
        return mno;
    }

    public void setMno(Integer mno) {
        this.mno = mno;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMhref() {
        return mhref;
    }

    public void setMhref(String mhref) {
        this.mhref = mhref;
    }

    public String getMtarget() {
        return mtarget;
    }

    public void setMtarget(String mtarget) {
        this.mtarget = mtarget;
    }

    public Integer getPno() {
        return pno;
    }

    public void setPno(Integer pno) {
        this.pno = pno;
    }

    public Menu getParent() {
        return parent;
    }

    public void setParent(Menu parent) {
        this.parent = parent;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public String getYl1() {
        return yl1;
    }

    public void setYl1(String yl1) {
        this.yl1 = yl1;
    }

    public String getYl2() {
        return yl2;
    }

    public void setYl2(String yl2) {
        this.yl2 = yl2;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "mno=" + mno +
                ", mname='" + mname + '\'' +
                ", mhref='" + mhref + '\'' +
                ", mtarget='" + mtarget + '\'' +
                ", pno=" + pno +
                ", parent=" + parent +
                ", children=" + children +
                ", yl1='" + yl1 + '\'' +
                ", yl2='" + yl2 + '\'' +
                '}';
    }
}
