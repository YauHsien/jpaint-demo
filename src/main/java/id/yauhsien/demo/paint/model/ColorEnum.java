package id.yauhsien.demo.paint.model;

public enum ColorEnum {

    a('a'),b('b'),c('c'),d('d'),e('e'),f('f'),g('g'),
    h('h'),i('i'),j('j'),k('k'),l('l'),m('m'),n('n'),
    o('o'),p('p'),q('q'),r('r'),s('s'),t('t'),u('u'),
    v('v'),w('w'),x('x'),y('y'),z('z'),
    A('A'),B('B'),C('C'),D('D'),E('E'),F('F'),G('G'),
    H('H'),I('I'),J('J'),K('K'),L('L'),M('M'),N('N'),
    O('O'),P('P'),Q('Q'),R('R'),S('S'),T('T'),U('U'),
    V('V'),W('W'),X('X'),Y('Y'),Z('Z'),
    background(' ');

    private char character;

    ColorEnum(char character) {
        this.character = character;
    }

    @Override
    public String toString() {
        return "" + character;
    }
}
