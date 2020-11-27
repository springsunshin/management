package com.dao;

public class DeleteProvide {

    public String deleteUsers(Integer[] unos) {
        StringBuilder builder = new StringBuilder("delete from t_user where uno ");
        if (unos.length > 0) {
            builder.append("in (");
            for (int i = 0; i < unos.length; i++) {
                builder.append(unos[i]);
                builder.append(",");
            }
            builder.delete(builder.length()-1,builder.length());
            builder.append(")");
        }
        return builder.toString();
    }
}
