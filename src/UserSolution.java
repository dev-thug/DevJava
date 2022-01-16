//import java.util.ArrayList;
//import java.util.List;
//
//class UserSolution {
//    private List<Stock> buyList = new ArrayList<>();
//    private List<Stock> sellList = new ArrayList<>();
//
//    public void init() {
//    }
//
//    public int buy(int mNumber, int mStock, int mQuantity, int mPrice) {
//
//        if (sellList.size()>0){
//            for(Stock stock: sellList){
//                if (stock)
//            }
//        }
//
//        buyList.add(new Stock(mNumber, mStock, mQuantity, mPrice));
//        return 0;
//    }
//
//    public int sell(int mNumber, int mStock, int mQuantity, int mPrice) {
//        sellList.add(new Stock(mNumber, mStock, mQuantity, mPrice));
//        return 0;
//    }
//
//    public void cancel(int mNumber) {
//    }
//
//    public int bestProfit(int mStock) {
//        return 0;
//    }
//
//    class Stock {
//        int mNumber, mStock, mQuantity, mPrice;
//
//        public Stock(int mNumber, int mStock, int mQuantity, int mPrice) {
//            this.mNumber = mNumber;
//            this.mStock = mStock;
//            this.mQuantity = mQuantity;
//            this.mPrice = mPrice;
//        }
//
//        public int getmNumber() {
//            return mNumber;
//        }
//
//        public void setmNumber(int mNumber) {
//            this.mNumber = mNumber;
//        }
//
//        public int getmStock() {
//            return mStock;
//        }
//
//        public void setmStock(int mStock) {
//            this.mStock = mStock;
//        }
//
//        public int getmQuantity() {
//            return mQuantity;
//        }
//
//        public void setmQuantity(int mQuantity) {
//            this.mQuantity = mQuantity;
//        }
//
//        public int getmPrice() {
//            return mPrice;
//        }
//
//        public void setmPrice(int mPrice) {
//            this.mPrice = mPrice;
//        }
//    }
//}