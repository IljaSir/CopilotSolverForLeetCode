impl Solution {
    pub fn find_the_winner(n: i32, k: i32) -> i32 {
        
        let mut friends = vec![1; n as usize];
        let mut i = 0;
        let mut count = 0;
        while count < n - 1 {
            if friends[i] == 1 {
                let mut j = 0;
                while j < k {
                    i = (i + 1) % n as usize;
                    if friends[i] == 1 {
                        j += 1;
                    }
                }
                friends[i] = 0;
                count += 1;
            } else {
                i = (i + 1) % n as usize;
            }
        }
        let mut i = 0;
        while i < n as usize {
            if friends[i] == 1 {
                break;
            }
            i += 1;
        }
        (i + 1) as i32
    }
}