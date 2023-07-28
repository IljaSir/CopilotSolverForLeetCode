impl Solution {
    pub fn total_fruit(fruits: Vec<i32>) -> i32 {
        
        let mut ans = 0;
        let mut i = 0;
        let mut j = 0;
        let mut basket = std::collections::HashMap::new();
        while j < fruits.len() {
            *basket.entry(fruits[j]).or_insert(0) += 1;
            while basket.len() > 2 {
                *basket.entry(fruits[i]).or_insert(0) -= 1;
                if basket[&fruits[i]] == 0 {
                    basket.remove(&fruits[i]);
                }
                i += 1;
            }
            ans = ans.max(j - i + 1);
            j += 1;
        }
        ans as i32
    }
}