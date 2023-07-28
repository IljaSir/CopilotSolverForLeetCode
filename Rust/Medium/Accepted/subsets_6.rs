impl Solution {
    pub fn subsets(nums: Vec<i32>) -> Vec<Vec<i32>> {
        

        let mut res = Vec::new();
        res.push(Vec::new());
        for &n in nums.iter() {
            let mut new_res = Vec::new();
            for v in res.iter() {
                let mut new_v = v.clone();
                new_v.push(n);
                new_res.push(new_v);
            }
            res.append(&mut new_res);
        }
        res
    }
}