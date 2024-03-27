enum BloodType {
    //creating enum and attaching string values to the blood types
    Group("A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-");
    private final String APlus;
    private final String ANeg;
    private final String BPlus;
    private final String BNeg;
    private final String ABPlus;
    private final String ABNeg;
    private final String OPlus;
    private final String ONeg;



//constructor for blood types followed by setters
    BloodType(String APlus, String ANeg, String BPlus, String BNeg, String ABPlus, String ABNeg, String OPlus, String ONeg){
        this.APlus = APlus;
        this.ANeg = ANeg;
        this.BPlus = BPlus;
        this.BNeg = BNeg;
        this.ABPlus = ABPlus;
        this.ABNeg = ABNeg;
        this.OPlus = OPlus;
        this.ONeg = ONeg;


    }
    public String APlus(){
        return APlus;
    }
    public String ANeg(){
        return ANeg;
    }
    public String BPlus(){
        return BPlus;
    }
    public String BNeg(){
        return BNeg;
    }
    public String ABPlus(){
        return ABPlus;
    }
    public String ABNeg(){
        return ABNeg;
    }
    public String OPlus(){
        return OPlus;
    }
    public String ONeg(){
        return ONeg;
    }



}

