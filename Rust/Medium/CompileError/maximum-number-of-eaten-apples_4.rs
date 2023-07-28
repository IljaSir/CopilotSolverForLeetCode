impl Solution {
    pub fn eaten_apples(apples: Vec<i32>, days: Vec<i32>) -> i32 {
        
        let mut v = vec![];
        let mut ans = 0;
        for i in 0..apples.len() {
            if apples[i] > 0 {
                v.push((i + days[i] as usize, apples[i]));
            }
            v.sort_by(|a, b| a.0.cmp(&b.0));
            while v.len() > 0 && v[0].0 <= i {
                v.remove(0);
            }
            if v.len() > 0 {
                ans += 1;
                v[0].1 -= 1;
                if v[0].1 == 0 {
                    v.remove(0);
                }
            }
        }
        let mut i = apples.len();
        while v.len() > 0 {
            v.sort_by(|a, b| a.0.cmp(&b.0));
            for j in 0..v.len() {
                if v[j].0 > i {
                    ans += v[j].0 - i;
                    i = v[j].0;
                    break;
                }
            }
            while v.len() > 0 && v[0].0 <= i {
                v.remove(0);
            }
            if v.len() > 0 {
                ans += 1;
                v[0].1 -= 1;
                if v[0].1 == 0 {
                    v.remove(0);
                }
            }
            i += 1;
        }
        ans
    }
}