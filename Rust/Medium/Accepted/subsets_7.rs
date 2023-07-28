impl Solution {
    pub fn subsets(nums: Vec<i32>) -> Vec<Vec<i32>> {
        

        let mut res = vec![vec![]];
        for num in nums {
            let mut new = vec![];
            for list in res.iter() {
                let mut temp = list.clone();
                temp.push(num);
                new.push(temp);
            }
            res.append(&mut new);
        }
        res
    }
}