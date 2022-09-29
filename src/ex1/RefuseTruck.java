package ex1;

public class RefuseTruck {
    private int noOfBinsDeclined, noOfBinsCollected, maxBins;
    private double ratePerKilo;
    private double totalWeight;

    public RefuseTruck(int noBins, double ratePerKilo){
        this.maxBins = noBins;
        this.ratePerKilo =ratePerKilo;
        this.noOfBinsCollected=0;
        this.noOfBinsDeclined=0;
    }

    public boolean collectBin(double weight){
        boolean overweight = false;
        if(weight<100 && noOfBinsCollected <= maxBins){
            noOfBinsCollected++;
            totalWeight+= weight;
        }else {
            noOfBinsDeclined++;
            System.out.println("Bin is over 100kg weight - Collection declined");
            overweight = true;
        }

        return  overweight;
    }

    public int getNoOfBinsCollected(){
        return noOfBinsCollected;
    }

    public int getMaxBins(){
        return maxBins;
    }

    public void printStats(){
        System.out.println("\n No of Bins collected: "+ noOfBinsCollected + "bins");
        System.out.println("\n No of Bins not collected: "+ noOfBinsDeclined+ "bins");
        System.out.printf("Average Weight of bins collected is: %.2f kg %n", (totalWeight/noOfBinsCollected));
        System.out.printf("Average cost of bins collected is €%.2f", ((totalWeight/noOfBinsCollected)*ratePerKilo));
    }
}
