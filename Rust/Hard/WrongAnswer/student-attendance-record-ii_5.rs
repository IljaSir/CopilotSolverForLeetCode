impl Solution {
    pub fn check_record(n: i32) -> i32 {
        
        let mut a = 1;
        let mut p = 1;
        let mut l = 1;
        let mut la = 0;
        let mut lp = 0;
        let mut ll = 0;
        let mut modu = 1000000007;
        for _ in 1..n {
            let na = (a + p + l) % modu;
            let np = a;
            let nl = p;
            let nla = (la + lp + ll) % modu;
            let nlp = la;
            let nll = lp;
            a = na;
            p = np;
            l = nl;
            la = nla;
            lp = nlp;
            ll = nll;
        }
        (a + p + l + la + lp + ll) % modu
    }
}