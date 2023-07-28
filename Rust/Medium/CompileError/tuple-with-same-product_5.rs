impl Solution {
    pub fn tuple_same_product(nums: Vec<i32>) -> i32 {
        
        let mut m: HashMap<i32, i32> = HashMap::new();
        let mut res = 0;
        for i in 0..nums.len() {
            for j in i+1..nums.len() {
                let p = nums[i] * nums[j];
                *m.entry(p).or_insert(0) += 1;
            }
        }
        for (_, v) in m.iter() {
            res += v * (v - 1);
        }
        res * 8
    }
}