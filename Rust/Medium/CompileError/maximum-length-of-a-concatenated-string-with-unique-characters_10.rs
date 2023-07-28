impl Solution {
    pub fn max_length(arr: Vec<String>) -> i32 {
        
        let mut arr = arr.into_iter().map(|s| {
            let mut mask = 0;
            for c in s.chars() {
                let i = c as u8 - b'a';
                if mask & (1 << i) > 0 {
                    return 0;
                }
                mask |= 1 << i;
            }
            mask
        }).collect::<Vec<_>>();
        arr.sort_unstable_by_key(|&mask| mask.count_ones());
        let mut ans = 0;
        let mut masks = vec![0];
        for &mask in arr.iter().rev() {
            if mask == 0 {
                continue;
            }
            let mut next = Vec::new();
            for &m in masks.iter() {
                if m & mask == 0 {
                    ans = ans.max(m.count_ones() + mask.count_ones());
                    next.push(m | mask);
                }
            }
            masks.append(&mut next);
        }
        ans as i32
    }
}