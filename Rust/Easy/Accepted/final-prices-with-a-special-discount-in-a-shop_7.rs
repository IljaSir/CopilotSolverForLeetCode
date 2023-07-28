impl Solution {
    pub fn final_prices(prices: Vec<i32>) -> Vec<i32> {
        
        let mut output: Vec<i32> = Vec::new();
        for i in 0..prices.len() {
            let mut discount = 0;
            for j in i+1..prices.len() {
                if prices[j] <= prices[i] {
                    discount = prices[j];
                    break;
                }
            }
            output.push(prices[i] - discount);
        }
        output
    }
}