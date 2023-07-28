impl Solution {
    pub fn combine(n: i32, k: i32) -> Vec<Vec<i32>> {
        

        let mut result: Vec<Vec<i32>> = Vec::new();
        let mut tmp: Vec<i32> = Vec::new();
        let n = n as usize;
        let k = k as usize;
        Self::dfs(&mut result, &mut tmp, n, k, 1);
        result
    }
    
    fn dfs(result: &mut Vec<Vec<i32>>, tmp: &mut Vec<i32>, n: usize, k: usize, start: usize) {
        if tmp.len() == k {
            result.push(tmp.clone());
            return;
        }
        for i in start..=n {
            tmp.push(i as i32);
            Self::dfs(result, tmp, n, k, i + 1);
            tmp.pop();
        }
    }
}