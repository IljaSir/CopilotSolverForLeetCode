impl Solution {
    pub fn largest_variance(s: String) -> i32 {
        
        let mut max = 0;
        let mut counts = vec![0; 26];
        let mut prev = vec![0; 26];
        let mut next = vec![0; 26];
        let mut c = s.chars();
        let mut n = c.next();
        while let Some(c) = n {
            next[c as usize - 'a' as usize] += 1;
            n = c.next();
        }
        let mut n = c.next();
        while let Some(c) = n {
            prev.copy_from_slice(&next);
            next.copy_from_slice(&counts);
            next[c as usize - 'a' as usize] += 1;
            let mut min = i32::MAX;
            let mut max = 0;
            for i in 0..26 {
                let diff = (prev[i] - next[i]).abs();
                if diff < min {
                    min = diff;
                }
                if diff > max {
                    max = diff;
                }
            }
            let diff = max - min;
            if diff > max {
                max = diff;
            }
            n = c.next();
        }
        max
    }
}