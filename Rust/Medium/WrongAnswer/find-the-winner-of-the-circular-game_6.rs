impl Solution {
    pub fn find_the_winner(n: i32, k: i32) -> i32 {
        
        let mut a = vec![1; n as usize];
        let mut i = 0;
        let mut c = 0;
        while c < n - 1 {
            if a[i] == 1 {
                let mut j = 0;
                while j < k {
                    i = (i + 1) % n as usize;
                    if a[i] == 1 {
                        j += 1;
                    }
                }
                a[i] = 0;
                c += 1;
            } else {
                i = (i + 1) % n as usize;
            }
        }
        for (i, &x) in a.iter().enumerate() {
            if x == 1 {
                return (i + 1) as i32;
            }
        }
        0
    }
}