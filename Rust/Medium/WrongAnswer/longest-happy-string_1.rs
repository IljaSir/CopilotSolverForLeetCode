impl Solution {
    pub fn longest_diverse_string(a: i32, b: i32, c: i32) -> String {
        
        let mut v = vec![('a', a), ('b', b), ('c', c)];
        let mut res = String::new();
        while v[0].1 > 0 || v[1].1 > 0 || v[2].1 > 0 {
            v.sort_by(|x, y| y.1.cmp(&x.1));
            let mut i = 0;
            while i < 2 && v[i].1 == 0 {
                i += 1;
            }
            let mut j = i + 1;
            while j < 3 && v[j].1 == 0 {
                j += 1;
            }
            if v[i].1 >= 2 && (v[i].0 != res.chars().last().unwrap_or(' ') || j == 3) {
                res.push(v[i].0);
                res.push(v[i].0);
                v[i].1 -= 2;
            } else {
                res.push(v[i].0);
                v[i].1 -= 1;
            }
        }
        res
    }
}