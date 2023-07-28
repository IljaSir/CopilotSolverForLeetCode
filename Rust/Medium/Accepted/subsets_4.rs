impl Solution {
    pub fn subsets(nums: Vec<i32>) -> Vec<Vec<i32>> {
        

        let mut result = vec![vec![]];
        for n in nums {
            let mut temp = vec![];
            for r in result.iter() {
                let mut v = r.clone();
                v.push(n);
                temp.push(v);
            }
            result.extend(temp);
        }
        result
    }
}