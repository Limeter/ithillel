public abstract class Animal implements Noisy{

    protected String name;

    public Animal(String name){
        this.name = name;
    }

    protected void whoAmI(){
        System.out.print(name.toUpperCase() + ": " );
    }
    protected void out(String smth){
        whoAmI();
        System.out.println(smth);
    }
}