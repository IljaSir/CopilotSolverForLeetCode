impl Solution {
    pub fn construct2_d_array(original: Vec<i32>, m: i32, n: i32) -> Vec<Vec<i32>> {
        
        let mut res = vec![vec![]];
        let mut m = m as usize;
        let mut n = n as usize;
        let mut i = 0;
        while i < original.len() {
            if res.last().unwrap().len() == n {
                res.push(vec![]);
            }
            res.last_mut().unwrap().push(original[i]);
            i += 1;
        }
        if res.len() == m {
            res
        } else {
            vec![]
        }
    }
}