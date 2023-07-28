impl Solution {
    pub fn longest_diverse_string(a: i32, b: i32, c: i32) -> String {
        
        let mut count = vec![(a, 'a'), (b, 'b'), (c, 'c')];
        count.sort_by(|a, b| b.0.cmp(&a.0));
        let mut res = String::new();
        let mut prev = ' ';
        let mut prev_count = 0;
        while count[0].0 > 0 {
            let mut i = 0;
            while i < 3 && (count[i].0 == 0 || (count[i].1 == prev && prev_count == 2)) {
                i += 1;
            }
            if i == 3 {
                break;
            }
            res.push(count[i].1);
            count[i].0 -= 1;
            if count[i].1 == prev {
                prev_count += 1;
            } else {
                prev = count[i].1;
                prev_count = 1;
            }
        }
        res
    }
}