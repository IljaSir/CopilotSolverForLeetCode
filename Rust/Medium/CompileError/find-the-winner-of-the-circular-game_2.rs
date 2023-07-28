impl Solution {
    pub fn find_the_winner(n: i32, k: i32) -> i32 {
        
        let mut v = (1..=n).collect::<Vec<i32>>();
        let mut i = 0;
        while v.len() > 1 {
            i = (i + k - 1) % v.len();
            v.remove(i);
        }
        v[0]
    }
}