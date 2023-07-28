impl Solution {
    pub fn distinct_integers(n: i32) -> i32 {
        
        let mut count = 0;
        let mut arr = vec![false; n as usize + 1];
        for i in 1..=n {
            if !arr[i as usize] {
                count += 1;
                let mut j = i;
                while j <= n {
                    arr[j as usize] = true;
                    j += i;
                }
            }
        }
        count
    }
}