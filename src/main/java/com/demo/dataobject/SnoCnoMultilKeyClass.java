package com.demo.dataobject;

import java.io.Serializable;

public class SnoCnoMultilKeyClass implements Serializable {

    private static final long serialVersionUID = 1L;

    private String sno;

    private String cno;

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public SnoCnoMultilKeyClass(String sno, String cno) {
        this.sno = sno;
        this.cno = cno;
    }

    public SnoCnoMultilKeyClass() {
    }

    /**
     *重写equals和hashcode方法
     * equals方法用于判断两个对象是否相等，EntityManager
     * 通过find方法来查找Entity时，是根据equals的返回值来判断的。
     * hashCode方法返回当前对象的哈希码
     * @return
     */

    @Override
    public int hashCode(){
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ((sno == null) ? 0: sno.hashCode());
        result = PRIME * result + ((cno == null) ? 0 : cno.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj ){
            return true;
        }
        if(obj == null ) {
           return false;
        }
        if(getClass() != obj.getClass()) {
            return false;
        }

        final SnoCnoMultilKeyClass other = (SnoCnoMultilKeyClass)obj;

        if( sno == null ) {
            if(other.sno != null){
                return false;
            }
        } else if(!sno.equals(other.sno)){
            return false;
        }
        if(cno == null){
            if(other.cno != null) {
                return false;
            }
        } else if (!cno.equals(other.cno)){
            return false;
        }

        return true;
    }
}
