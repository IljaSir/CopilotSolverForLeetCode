impl Solution {
    pub fn combine(n: i32, k: i32) -> Vec<Vec<i32>> {
        

        let mut res = Vec::new();
        let mut temp = Vec::new();
        backtrack(n, k, &mut res, 1, &mut temp);
        res
    }
}