impl Solution {
    pub fn subsets(nums: Vec<i32>) -> Vec<Vec<i32>> {
        

        let mut res = vec![vec![]];
        for n in nums {
            let mut tmp = vec![];
            for r in &res {
                tmp.push([r.to_vec(), vec![n]].concat());
            }
            res.append(&mut tmp);
        }
        res
    }
}