impl Solution {
    pub fn combine(n: i32, k: i32) -> Vec<Vec<i32>> {
        

        let mut res = Vec::new();
        let mut temp = Vec::new();
        Solution::helper(n, k, 1, &mut temp, &mut res);
        res
    }
    fn helper(n: i32, k: i32, start: i32, temp: &mut Vec<i32>, res: &mut Vec<Vec<i32>>) {
        if temp.len() == k as usize {
            res.push(temp.clone());
            return;
        }
        for i in start..=n {
            temp.push(i);
            Solution::helper(n, k, i + 1, temp, res);
            temp.pop();
        }
    }
}