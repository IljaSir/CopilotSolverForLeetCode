impl Solution {
    pub fn count_arrangement(n: i32) -> i32 {
        

        let n = n as usize;
        let mut used = vec![false; n];
        Self::count(&mut used, n, 0)
    }
    
    fn count(used: &mut Vec<bool>, n: usize, pos: usize) -> i32 {
        if pos == n {
            return 1;
        }
        let mut count = 0;
        for i in 0..n {
            if used[i] {
                continue;
            }
            if (i + 1) % (pos + 1) != 0 && (pos + 1) % (i + 1) != 0 {
                continue;
            }
            used[i] = true;
            count += Self::count(used, n, pos + 1);
            used[i] = false;
        }
        count
    }
}