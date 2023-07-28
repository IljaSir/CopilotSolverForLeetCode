impl Solution {
    pub fn sort_array_by_parity_ii(nums: Vec<i32>) -> Vec<i32> {
        
        let mut odd = Vec::new();
        let mut even = Vec::new();
        for i in nums {
            if i % 2 == 0 {
                even.push(i);
            } else {
                odd.push(i);
            }
        }
        let mut res = Vec::new();
        for i in 0..odd.len() {
            res.push(even[i]);
            res.push(odd[i]);
        }
        return res;
    }
}