import scala.util.parsing.combinator.lexical.Lexical
import scala.util.parsing.combinator.syntactical.TokenParsers

trait CSVLexical extends Lexical {
  case object CellDelimiter extends Token { def chars = "<cell-delim>" }
}

abstract class BaseCSVParsers extends TokenParsers {
  type Tokens <: CSVLexical
  def delimiter: Function[Elem, Boolean] = _.isInstanceOf[lexical.CellDelimiter.type]
}

