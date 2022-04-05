package net.seehope.common;

public enum JobStatus {
    SUCCESS(1), ERROR(0),WAIT(-1);

    private Integer type;

    JobStatus(Integer type){
        this.type = type;
    }


    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
