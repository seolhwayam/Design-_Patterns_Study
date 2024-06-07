interface Name {
    public void name();
}

class Jihye implements Name{

    @Override
    public void name() {
        System.out.println("나는 김지혜업니다.");
    }
}
class Seolhwa implements Name{

    @Override
    public void name() {
        System.out.println("나는 김설화입니다.");
    }
}

class people{
    Name name;

    public void setName(){
        name.name();
    }
}

class people_jihye extends people{
    public people_jihye(){
        name = new Jihye();
        setName();
    }

    public static void main(String[] args) {
        people_jihye p1 = new people_jihye();
    }
}






