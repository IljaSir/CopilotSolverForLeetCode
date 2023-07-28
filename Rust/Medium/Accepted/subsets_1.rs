impl Solution {
    pub fn subsets(nums: Vec<i32>) -> Vec<Vec<i32>> {
        

        let mut result = vec![vec![]];
        for n in nums {
            let mut temp = vec![];
            for r in &result {
                let mut t = r.clone();
                t.push(n);
                temp.push(t);
            }
            result.append(&mut temp);
        }
        result
    }
}