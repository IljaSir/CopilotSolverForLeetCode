impl Solution {
    pub fn arithmetic_triplets(nums: Vec<i32>, diff: i32) -> i32 {
        
        let mut c = 0;
        let mut m = std::collections::HashMap::new();
        for (i, x) in nums.iter().enumerate() {
            if let Some(&j) = m.get(&(x - diff)) {
                c += j;
            }
            *m.entry(x).or_insert(0) += i as i32;
        }
        c
    }
}