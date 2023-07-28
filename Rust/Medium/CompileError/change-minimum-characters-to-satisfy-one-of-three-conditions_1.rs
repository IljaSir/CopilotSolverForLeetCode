impl Solution {
    pub fn min_characters(a: String, b: String) -> i32 {
        
        let mut a = a.bytes().collect::<Vec<u8>>();
        let mut b = b.bytes().collect::<Vec<u8>>();
        a.sort();
        b.sort();
        let mut count = 0;
        let a_len = a.len();
        let b_len = b.len();
        let a_max = a[a_len - 1];
        let b_max = b[b_len - 1];
        let mut a_min = a[0];
        let mut b_min = b[0];
        let mut a_sum = 0;
        let mut b_sum = 0;
        let mut a_count = 0;
        let mut b_count = 0;
        let mut a_count2 = 0;
        let mut b_count2 = 0;
        let mut a_count3 = 0;
        let mut b_count3 = 0;
        let mut a_count4 = 0;
        let mut b_count4 = 0;
        let mut a_count5 = 0;
        let mut b_count5 = 0;
        let mut a_count6 = 0;
        let mut b_count6 = 0;
        for i in 0..a_len {
            a_sum += a[i];
            a_count += 1;
            if a[i] == a_min {
                a_count2 += 1;
            }
            if a[i] == a_max {
                a_count3 += 1;
            }
            if a[i] == b_min {
                a_count4 += 1;
            }
            if a[i] == b_max {
                a_count5 += 1;
            }
            if a[i] != a_min && a[i] != a_max {
                a_count6 += 1;
            }
        }
        for i in 0..b_len {
            b_sum += b[i];
            b_count += 1;
            if b[i] == b_min {
                b_count2 += 1;
            }
            if b[i] == b_max {
                b_count3 += 1;
            }
            if b[i] == a_min {
                b_count4 += 1;
            }
            if b[i] == a_max {
                b_count5 += 1;
            }
            if b[i] != b_min && b[i] != b_max {
                b_count6 += 1;
            }
        }
        let mut
    }
}