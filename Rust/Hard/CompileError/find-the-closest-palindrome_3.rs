impl Solution {
    pub fn nearest_palindromic(n: String) -> String {
        
        let n: Vec<char> = n.chars().collect();
        let len = n.len();
        let mut res = String::new();
        let mut i = 0;
        while i < (len + 1) / 2 {
            res.push(n[i]);
            i += 1;
        }
        if len % 2 == 1 {
            i -= 1;
        }
        while i > 0 {
            i -= 1;
            res.push(n[i]);
        }
        let res = res.parse::<i64>().unwrap();
        let mut res1 = res - 1;
        let mut res2 = res + 1;
        let mut res3 = res;
        let mut res4 = res;
        let mut res5 = res;
        let mut res6 = res;
        let mut res7 = res;
        let mut res8 = res;
        let mut res9 = res;
        let mut res10 = res;
        let mut res11 = res;
        let mut res12 = res;
        let mut res13 = res;
        let mut res14 = res;
        let mut res15 = res;
        let mut res16 = res;
        let mut res17 = res;
        let mut res18 = res;
        let mut res19 = res;
        let mut res20 = res;
        let mut res21 = res;
        let mut res22 = res;
        let mut res23 = res;
        let mut res24 = res;
        let mut res25 = res;
        let mut res26 = res;
        let mut res27 = res;
        let mut res28 = res;
        let mut res29 = res;
        let mut res30 = res;
        let mut res31 = res;
        let mut res32 = res;
        let mut res33 = res;
        let mut res34 = res;
        let mut res35 = res;
        let mut res36 = res;
        let mut res37 = res;
        let mut res38 = res;
        let mut res39 = res;
        let mut res40 = res;
        let mut res41 = res;
        let mut res42 = res;
        let mut res43 = res;
        let mut res44 = res;
        let mut res45 = res;
        let mut res46 = res;
        let mut res47 = res;
    }
}