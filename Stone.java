public class Stone implements Comparable<Stone> {

        String name;
        Byte karat;
        float karatCost;
        Float stonePrice;
        String transparency;

        public Stone(String name, Byte karat, float karatCost, String transparency) {
            this.name = name;
            this.karat = karat;
            this.karatCost = karatCost;
            this.transparency = transparency;

            this.stonePrice = this.karat * this.karatCost;
        }

        public String getName() {
            return name;
        }

        public Byte getKarat() {
            return karat;
        }

        public Float getStonePrice() {
            return stonePrice;
        }

        @Override
        public String toString() {
            return "Stone: " + name +
                    ", karat = " + karat +
                    ", karatCost = " + karatCost +
                    ", stonePrice =" + stonePrice +
                    ", transparency: " + transparency + "\n";
        }

        @Override
        public int compareTo(Stone s) {
            return karat.compareTo(s.getKarat());
        }
}

