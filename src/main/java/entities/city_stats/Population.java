package entities.city_stats;

public class Population {

    private double pgr; //population growth rate
    private double pmr; //population mortality rate
    private int population;
    private int init_pop;

    private int time;
    private double counter;
    private double year_factor;

    public Population(double pgr, double pmr, int population, int init_pop) {
        this.pgr = pgr;
        this.pmr = pmr;
        this.population = population;
        this.init_pop = init_pop;
        time = 0;
        counter = 0;
        year_factor = 0.01;
    }
    public void add_pgr(double factor){
        pgr+=factor;
    }

    public void add_pmr(double factor){
        pmr+=factor;
    }

    private void calc_pop(int init_pop, double pgr, double pmr, double time){

        population = ((int) (init_pop*(Math.pow(1+pgr, time)))) - ((int) (init_pop* (Math.pow(1+pmr, time))));
    }

    public void update(){

        calc_pop(init_pop, pgr, pmr, time);

        counter+=year_factor;
        //System.out.println(population);
        if(counter >=1){
            time ++;
            counter = 0;
        }

    }


    /* GETTERS AND SETTERS */

    public double getPgr() {
        return pgr;
    }

    public void setPgr(double pgr) {
        this.pgr = pgr;
    }

    public double getPmr() {
        return pmr;
    }

    public void setPmr(double pmr) {
        this.pmr = pmr;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getInit_pop() {
        return init_pop;
    }

    public void setInit_pop(int init_pop) {
        this.init_pop = init_pop;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public double getCounter() {
        return counter;
    }

    public void setCounter(double counter) {
        this.counter = counter;
    }

    public double getYear_factor() {
        return year_factor;
    }

    public void setYear_factor(double year_factor) {
        this.year_factor = year_factor;
    }

}
