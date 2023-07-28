impl Solution {
    pub fn maximum_tastiness(price: Vec<i32>, k: i32) -> i32 {
        
        let mut price = price;
        price.sort();
        let mut ans = price[k as usize - 1] - price[0];
        for i in 1..=price.len() - k as usize {
            ans = ans.max(price[i + k as usize - 1] - price[i]);
        }
        ans
    }
}